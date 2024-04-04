def create_structure(names, goals, goals_avoided, assists):
    structure = {}
    i = 0
    for name in names:
        structure[name] = (goals[i], goals_avoided[i], assists[i])
        i += 1
    return structure

def max_goals(structure):
    max = -1
    nomMax = ""
    for key,value in structure.items():
        if value[0] > max:
            nomMax = key
            max = value[0]
    return nomMax, max

def most_influential(structure):
    max_stats = 0
    max_name = ""
    for key,value in structure.items():
        stats = value[0]*1.5+value[1]*1.25+value[2]
        if stats > max_stats:
            max_stats = stats
            max_name = key
    return max_name
            
def goal_average(structure):
    total_goals = 0
    for key,value in structure.items():
        total_goals += value[0]
    return total_goals/25
         
def goal_average_scorer(scorer):
    return scorer[0] / 25

# si o si tiene que estar implementado en un modulo
# es mejor sin utilizar lambda

# 