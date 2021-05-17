# IET 2. Házi feladat – Behaviour Driven Development Tesztelés

## **Tapasztalatok**
A feladat megoldásához a Cucumber frameworkre esett a választásunk, mmivel Gherkin nyelvű implementációjával könnyen használható és olvasható. A teszteseteket 4 kategóriába soroltuk, melyekhez tartozik egy Stepdefs.java fájl, ami a tesztesetek lépéseihez tartozó implementációkat tartalmazza, ezeket megpróbáltuk külön fájlokba szervezni, azonban mivel a pálya felépíte meg kell, hogy előzze az összes tesztet ezért az redundancia elkerülése érdekében egy fájlban maradtak, ez a fájl a  `src\test\java\com\csakcintanyer\bme\projlab` útvonalon érhető el, még a feature fájlok a `src\test\resources\com\csakcintanyer\bme\projlab` útvonalon.

## **Tesztesetek**
**Character move**

A karakter blokkok közötti mozgatásával kapcsolatos tesztek a character_move.feature fájlba kerültek leírásra. Az összes blokk típust lefedő mozgáshoz készült egy-egy teszt.


**Character use item**
 
 A karakterek eszköz használatával kapcsolator tesztek a character_useitem.feature fájlban találhatók. Ezekben a teszt scenariokban a karakterek törékeny valamint normál ásót és sátrat használnak. Ezeket egy stabil blokkos környezetben valósítják meg.

 **Character use ability**

 A karakterek képesség használatával kapcsoaltos tesztek a character_ability.feature fájlban találhatók. Ezekben a két különböző típusú karakter (eszkimó, felfedező) képességhasználata található. Az eszkimó iglu építése, valamint a felfedező blokkvizsgáló képessége kerül tesztelésre.

 **Win the game**

A játék megnyerési mechanikájával kapcsolatos tesztek a win_the_game.feature fájlba kerültek. Az egyik tesztesetben a karakternek nincs meg az összes eszköze ahhoz, hogy megnyerje a játékot. És ekkor elsütve a fegyvert, nem ér véget a játék. A másik esetben minden adott a játék megnyeréséhez, ekkor elsütve a fegyvert a játék véget ért és a játékos nyert.


