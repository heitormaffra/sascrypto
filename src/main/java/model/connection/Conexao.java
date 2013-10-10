/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection conexao = null;

    public static Connection getConnection() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        if (conexao == null) {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/syscrypto", "adm", "adm");
        }
        return conexao;
    }

    public static void closeConnection() throws Exception {
        conexao.close();
    }
}
