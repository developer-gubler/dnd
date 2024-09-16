from fastapi import FastAPI
import psycopg2

app = FastAPI()
conn = psycopg2.connect(database="dnd-database",
                        host="172.18.0.2",
                        user="dnd-user",
                        password="dnd-secret",
                        port="5432")

@app.get("/api/dnd/equipment/creature-armor-list")
async def root(creature_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',a.id,'name',a.name,'price',a.price,'weight',a.weight,'type',a.type,'ac',a.ac,'add_dex',a.add_dex,'max_dex_bonus',a.max_dex_bonus,'str_req',a.str_req,'stealth_disadvantage',a.stealth_disadvantage)) FROM creature_armor_xref cax INNER JOIN armor a ON a.id=cax.armor_id WHERE creature_id=%s", (creature_id,))
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/creature-armor-proficiency")
async def root(creature_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('type',type)) FROM creature_armor_proficiency WHERE creature_id=%s", (creature_id,))
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/armor-list")
async def root():
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',id,'name',name,'price',price,'weight',weight,'type',type,'ac',ac,'add_dex',add_dex,'max_dex_bonus',max_dex_bonus,'str_req',str_req,'stealth_disadvantage',stealth_disadvantage)) FROM armor")
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/armor")
async def root(armor_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',id,'name',name,'price',price,'weight',weight,'type',type,'ac',ac,'add_dex',add_dex,'max_dex_bonus',max_dex_bonus,'str_req',str_req,'stealth_disadvantage',stealth_disadvantage)) FROM armor WHERE id=%s", (armor_id,))
    results = cursor.fetchone()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/creature-weapon-list")
async def root(creature_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',w.id,'name',w.name,'price',w.price,'damage',w.damage,'dmg_type',w.dmg_type,'weight',w.weight,'wpn_type',w.wpn_type,'ammunition',w.ammunition,'finesse',w.finesse,'heavy',w.heavy,'light',w.light,'loading',w.loading,'reach',w.reach,'special',w.special,'thrown',w.thrown,'two_handed',w.two_handed,'versatile',w.versatile)) FROM creature_weapon_xref cwx INNER JOIN weapon w ON w.id=cwx.weapon_id WHERE creature_id=%s", (creature_id,))
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/creature-weapon-proficiency")
async def root(creature_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',w.id,'name',w.name,'price',w.price,'damage',w.damage,'dmg_type',w.dmg_type,'weight',w.weight,'wpn_type',w.wpn_type,'ammunition',w.ammunition,'finesse',w.finesse,'heavy',w.heavy,'light',w.light,'loading',w.loading,'reach',w.reach,'special',w.special,'thrown',w.thrown,'two_handed',w.two_handed,'versatile',w.versatile)) FROM creature_weapon_proficiency cwp INNER JOIN weapon w ON w.id=cwp.weapon_id WHERE creature_id=%s", (creature_id,))
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/weapon-list")
async def root():
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',id,'name',name,'price',price,'damage',damage,'dmg_type',dmg_type,'weight',weight,'wpn_type',wpn_type,'ammunition',ammunition,'finesse',finesse,'heavy',heavy,'light',light,'loading',loading,'reach',reach,'special',special,'thrown',thrown,'two_handed',two_handed,'versatile',versatile)) FROM weapon")
    results = cursor.fetchall()
    cursor.close()
    return results

@app.get("/api/dnd/equipment/weapon")
async def root(weapon_id : str):
    cursor = conn.cursor()
    cursor.execute("SELECT to_json(json_build_object('id',id,'name',name,'price',price,'damage',damage,'dmg_type',dmg_type,'weight',weight,'wpn_type',wpn_type,'ammunition',ammunition,'finesse',finesse,'heavy',heavy,'light',light,'loading',loading,'reach',reach,'special',special,'thrown',thrown,'two_handed',two_handed,'versatile',versatile)) FROM weapon WHERE id=%s", (weapon_id,))
    results = cursor.fetchone()
    cursor.close()
    return results