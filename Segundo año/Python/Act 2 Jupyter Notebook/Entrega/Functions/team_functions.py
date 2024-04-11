def create_structure(names, goals, goals_avoided, assists):
    """Esta función crea una lista de diccionarios donde
        cada elemento de la lista corresponde a un jugador
        que guarda las estadisticas en un diccionario"""
    
    structure = list(zip(names,goals,goals_avoided,assists))
    lista = []
    for n,g,ga,a in structure:
        lista.append({'name':n,'goals':g,'goals_avoided':ga,'asissts':a})
    return lista

def max_goals(structure):
    """"Esta función recibe una lista de diccionarios, utiliza
        la funcion max usando como parametro el valor de
        la clave "goals" y devuelve el valor de la clave
        "goals" y "name" """
    
    scorer = max(structure, key=lambda x: x["goals"]) 
    return scorer["name"],scorer["goals"]

def most_influential(structure):
    """"Esta función recibe una lista de diccionarios 
        y utiliza una función max con parametro "goals"
        y devuelve la clave "name" del máximo diccionario"""
        
    return max(structure, key=lambda x: x["goals"]*1.5 + x["goals_avoided"]*1.25 + x["asissts"])["name"]
            
def goal_average(structure,GAMES):
    """Esta función recibe una lista de diccionarios,
       suma los elementos en la clave "goals" y los
       divide por la cantidad de partidos"""
       
    return sum(elem["goals"] for elem in structure) / GAMES
         
def goal_average_scorer(goals_scorer,GAMES):
    """Esta función recibe un entero que representa
        el valor de la clave goals del elemento de 
        la lista correspondiente al goleador y devuelve
        el promedio de goles por partido"""

    return goals_scorer / GAMES