package sample;

public class DatabaseController {

    /*
    * Kontroler bazy danych. Kontroler tworzy baze danych gdy jej nie ma. Nastepnie tworzy tabele.
    * Gdy tabela jest pusta to tworzy sie insert do bazy z nowo odczytana lokalizacja z API.
    * Gdy sa tam jakies dane to sa one nadpisywane przez odczytana lokalizacje z API.
    * */

    public static void Controller(Location location){

        DatabaseConnection.stworzTabele(DatabaseConnection.polacz());

        if(DatabaseConnection.isEmpty()){
            DatabaseConnection.updateDatabase(location);
        }else {
            DatabaseConnection.dodajDane(location);
        }
    }
}
