import streamlit as st
import requests

st.title("Dashboard Bancaire - Prédiction de Crédit")

# Formulaire à gauche
st.sidebar.header("Saisie Client")
age = st.sidebar.number_input("Âge", 18, 100, 30)
inc = st.sidebar.number_input("Revenu Mensuel ($)", 0, 100000, 3000)
debt = st.sidebar.number_input("Debt Ratio (ex: 0.5)", 0.0, 10000.0, 0.3)
loans = st.sidebar.number_input("Nombre de crédits", 0, 50, 2)

if st.sidebar.button("Analyser"):
    data = {"age": age, "income": inc, "debt_ratio": debt, "loans": loans}
    res = requests.post("http://127.0.0.1:8001/predict", json=data).json()
    st.write(f"### Résultat : {res['status']}")

# KPIs en haut
if st.button("Afficher les KPIs de la banque"):
    kpis = requests.get("http://127.0.0.1:8001/kpi").json()
    c1, c2, c3 = st.columns(3)
    c1.metric("Total Clients", kpis['total_clients'])
    c2.metric("Revenu Moyen", f"{kpis['revenu_moyen']:.0f} $")
    c3.metric("Taux de Défaut", f"{kpis['taux_defaut']:.2f} %")