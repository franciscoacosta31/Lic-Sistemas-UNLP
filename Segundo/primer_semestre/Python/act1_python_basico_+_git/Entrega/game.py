import random
# Lista de palabras posibles
words = ["python", "programación", "computadora", "código", "desarrollo","inteligencia"]

# Elegir una palabra al azar
secret_word = random.choice(words)

# Número máximo de intentos permitidos
max_fails = 10
fails = 0

# Lista para almacenar las letras adivinadas
guessed_letters = []

print("¡Bienvenido al juego de adivinanzas!")
print("Estoy pensando en una palabra. ¿Puedes adivinar cuál es?")

difficulty = int(input("""Seleccione una dificultad: 
      1 = Easy
      2 = Medium
      3 = Hard
      """))

match difficulty:
    case 1: 
        word_displayed = ""
        # si es una vocal, la revelo. Si no es, agrego "_"
        for letter in secret_word:
            if letter in "aeiou":
                word_displayed += letter
            else:
                word_displayed += "_"
    case 2: 
        word_displayed = ""
        # revelo la primer letra de la palabra
        word_displayed += secret_word[0]
        # relleno la palabra con "_" hasta llegar a la ultima posición en la que revelo la letra
        for i in range(len(secret_word)):
            if i == len(secret_word) - 1:
                word_displayed += secret_word[-1]
            else:
                 word_displayed += "_"
    case 3:
        word_displayed = "_" * len(secret_word)

# Mostrar la palabra parcialmente adivinada
print(f"Palabra: {word_displayed}")
while(fails < max_fails):
    # Pedir al jugador que ingrese una letra
    letter = input("Ingresa una letra: ").lower()
    # Verificar si la letra ya ha sido adivinada
    if letter in guessed_letters:
        print("Ya has intentado con esa letra. Intenta con otra.")
        continue
    # Agregar la letra a la lista de letras adivinadas

    guessed_letters.append(letter)
    # Verificar si la letra está en la palabra secreta
    # Agrego la segunda condición para que cuando no se ingrese nada, cuente como que el caracter no se encuentra en la palabra
    if letter in secret_word and letter != "":
        print("¡Bien hecho! La letra está en la palabra.")
    else:
        print("Lo siento, la letra no está en la palabra.")
        fails += 1
    # Mostrar la palabra parcialmente adivinada
    letters = []
    match difficulty:
        case 1:
            for letter in secret_word:
                if letter in guessed_letters or letter in "aeiou":   # agrego "or letter in 'aeiou'" para seguir revelando las vocales  
                    letters.append(letter)
                else:
                    letters.append("_")
        case 2:
            letters.append(secret_word[0])
            for i in range(1,len(secret_word)):
                if secret_word[i] in guessed_letters or i == (len(secret_word) -1):
                    letters.append(secret_word[i])
                else:
                    letters.append("_")
        case 3:
            for letter in secret_word:
                if letter in guessed_letters:
                    letters.append(letter)
                else:
                    letters.append("_")
    word_displayed = "".join(letters)
    print(f"Palabra: {word_displayed}")
    # Verificar si se ha adivinado la palabra completa
    if word_displayed == secret_word:
        print(f"¡Felicidades! Has adivinado la palabra secreta:{secret_word}")
        break
else:
    print(f"¡Oh no! Has alcanzado los {max_fails} fallos.")
    print(f"La palabra secreta era: {secret_word}")