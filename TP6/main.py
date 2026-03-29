from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

app = FastAPI(title="E-commerce Platform API")

# --- MODÈLE DE DONNÉES (Page 3 du PDF) ---
class Item(BaseModel):
    name: str
    price: float
    in_stock: bool = True
    sales: int
    views: int

# --- BASE DE DONNÉES EN MÉMOIRE (Liste) ---
db = []

# --- 1. MANIPULATION DES DONNÉES (Page 3) ---
@app.get("/")
def home():
    return {"message": "Bienvenue sur l'API E-commerce & IA. Allez sur /docs pour tester !"}

# Créer un produit (POST)
@app.post("/items/")
def create_item(item: Item):
    db.append(item)
    return {"message": "Item créé", "item": item}

# Récupérer un produit spécifique (GET)
@app.get("/items/{item_id}")
def read_item(item_id: int):
    if item_id < len(db):
        return db[item_id]
    return {"error": "Produit non trouvé"}

# Lister tous les produits (GET - Page 4)
@app.get("/items/")
def list_items():
    return {"items": db, "count": len(db)}

# --- 2. KPI - BUSINESS INTELLIGENCE (Page 4) ---

@app.get("/kpi/total_products")
def total_products():
    return {"total": len(db)}

@app.get("/kpi/total_value")
def total_value():
    total = sum(item.price for item in db)
    return {"total_value": total}

@app.get("/kpi/in_stock")
def in_stock_products():
    # On compte les produits où in_stock est True
    count = sum(1 for item in db if item.in_stock)
    return {"in_stock": count}

import pickle

# Charger le modèle au démarrage
with open("model.pkl", "rb") as f:
    model = pickle.load(f)

@app.post("/predict")
def predict(item: Item):
    # On prépare les données pour l'IA (Prix, Ventes, Vues)
    features = [[item.price, item.sales, item.views]]
    prediction = model.predict(features)[0]
    return {"prediction": prediction}