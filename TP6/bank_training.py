import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import pickle

df = pd.read_csv('cs-training.csv', index_col=0)

df['MonthlyIncome'] = df['MonthlyIncome'].fillna(df['MonthlyIncome'].median())
df['NumberOfDependents'] = df['NumberOfDependents'].fillna(0)

features = ['age', 'MonthlyIncome', 'DebtRatio', 'NumberOfOpenCreditLinesAndLoans']
X = df[features]
y = df['SeriousDlqin2yrs']

model = RandomForestClassifier(n_estimators=50, max_depth=10)
model.fit(X, y)

with open("bank_model.pkl", "wb") as f:
    pickle.dump(model, f)

print("Modèle 'bank_model.pkl' prêt.")