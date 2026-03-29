from fastapi import FastAPI
from pydantic import BaseModel
import pickle
import pandas as pd

app = FastAPI()

# Charger le modèle
with open("bank_model.pkl", "rb") as f:
    model = pickle.load(f)

# Charger les données pour les calculs de KPI
df_kpi = pd.read_csv('cs-training.csv', index_col=0)

class Client(BaseModel):
    age: int
    income: float
    debt_ratio: float
    loans: int

@app.get("/kpi")
def get_kpi():
    return {
        "total_clients": len(df_kpi),
        "revenu_moyen": float(df_kpi['MonthlyIncome'].mean()),
        "taux_defaut": float(df_kpi['SeriousDlqin2yrs'].mean() * 100),
        "clients_a_risque": int(df_kpi['SeriousDlqin2yrs'].sum())
    }

@app.post("/predict")
def predict(c: Client):
    # L'ordre doit être identique à l'entraînement : age, MonthlyIncome, DebtRatio, NumberOfOpenCreditLinesAndLoans
    data = [[c.age, c.income, c.debt_ratio, c.loans]]
    prediction = model.predict(data)[0]
    res = "Refusé (Risque)" if prediction == 1 else "Accepté (Sûr)"
    return {"status": res}