# SonarLint statikus analízis
Visual Studio Code és a SonarLint statikus analysis eszköz segítségével hibák felkutatása és javítása. A legtöbb helyen az @Override hiányzott, illetve a try blockokat try-with-resources blockokra alakítottam át. Ezen felül voltak if-ek amiknek a feltételeit össze lehetett vonni.

# Kód refaktorálás
A Jetbrains IntelliJ IDEA programjának segítségével refaktoráltam a fájlokat külön packagekbe. Ez után leteszteltem, hogy minden rendben fut-e ez után is. Mindent rendben találtam.
A tesztek írása során pár helyen át kellett írni a kódot, keletkezett egy hiba. Ezt hibát a tesztek nem dobták vissza, mert elég specifikus probléma, de sikerült megoldani.
