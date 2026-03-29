from sklearn.tree import DecisionTreeClassifier
import pickle

# Données d'entraînement (Prix, Ventes, Vues) -> Label (High, Medium, Low)
data = [
    {"price": 50, "sales": 200, "views": 1000, "label": "High"},
    {"price": 1200, "sales": 20, "views": 200, "label": "Low"},
    {"price": 300, "sales": 80, "views": 500, "label": "Medium"},
    {"price": 20, "sales": 300, "views": 1500, "label": "High"}
]

# Préparation des données
X = [[d["price"], d["sales"], d["views"]] for d in data]
y = [d["label"] for d in data]

# Entraînement
model = DecisionTreeClassifier()
model.fit(X, y)

# Sauvegarde du modèle dans un fichier
with open("model.pkl", "wb") as f:
    pickle.dump(model, f)

print("Modèle IA entraîné et sauvegardé dans model.pkl !")