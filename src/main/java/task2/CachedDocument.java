package task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class CachedDocument {
    private int id;
    private String gcsPath;
    private String parsed;

    public void save() {
        DBConnection dbConnection = DBConnection.getInstance();
        String query = String.format("insert into cache_table (gcsPath, parsed) values ('%s', '%s');",
                gcsPath, parsed.replace('\'', '\"'));
        dbConnection.executeQuery(query);
    }

    public int check() {
        DBConnection dbConnection = DBConnection.getInstance();
        String query = String.format("select count(*) from cache_table where gcsPath=('%s');", gcsPath);
        return dbConnection.checking(query);
    }

    public String get() {
        DBConnection dbConnection = DBConnection.getInstance();
        String query = String.format("select * from cache_table where gcsPath=('%s');", gcsPath);
        return dbConnection.getting(query);
    }
}
