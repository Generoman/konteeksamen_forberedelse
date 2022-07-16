## Hvordan laste ned prosjektet:

### Metode 1:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Velg `Download ZIP`
* Pakk ut ZIP-filen i en egenvalgt mappe, og åpne prosjektet i IntelliJ

### Metode 2:
* Trykk på den grønne "Code"-knappen oppe til høyre på GitHub
* Trykk på knappen til høyre for linken
* Velg `New -> Project from Version Control...` i IntelliJ
* Lim inn linken i URL-feltet og velg mappa hvor prosjektet skal lagres

## Viktig info:
`resources`-mappa mi inneholder en fil som heter `quiz.properties`. Innholdet i den filen ser slik ut:
```
url=DIN_DATABASE_URL_HER
username=DITT_BRUKERNAVN_HER
password=DITT_PASSORD_HER
```
Denne filen blir ikke tracket av Git siden den inneholder sensitiv informasjon. Du må opprette en slik fil selv for at programmet skal virke.

Husk også på å opprette og populere databasen med `creation.sql` og `population.sql` om du vil teste denne koden