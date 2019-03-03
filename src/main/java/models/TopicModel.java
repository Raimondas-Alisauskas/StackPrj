package models;

import controllers.DBconnection;
import utils.ConfigurationProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicModel {

    public static TopicResults getTopicsFromDB(SearchBin searchBin) {
        List<TopicBin> topics = new ArrayList<>();
        String tagId = searchBin.getTagId();
        String searchInput = searchBin.getSearchInput();
        int pageNumber = searchBin.getPageNumb();
        int numbOfTitles = ConfigurationProperties.SHOW_NUMB_OF_TITLES;
        int numbOfRecords = 0;


        Connection con = DBconnection.getConnection();
        if (con != null) try {

            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String sqlWhere = createWhereSQL(searchBin);
            int paramIndex;

            String sql = "SELECT count(*) FROM Topics";
            sql = sql + sqlWhere;

            PreparedStatement psCount;
            psCount = con.prepareStatement(sql);
            paramIndex = fillParamsToSQL(searchBin, psCount);

            ResultSet rsCount = psCount.executeQuery();
            rsCount.next();
            numbOfRecords = rsCount.getInt(1);


            sql = "SELECT Id, Title FROM Topics";
            sql = sql + sqlWhere;
            sql = sql + " ORDER BY ViewCount DESC LIMIT ?, ?";

            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            paramIndex = fillParamsToSQL(searchBin, ps);

            //cia uzdedam limit parametrus
            ps.setInt(paramIndex, ((pageNumber - 1) * numbOfTitles));
            paramIndex++;
            ps.setInt(paramIndex, numbOfTitles);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TopicBin topic = new TopicBin();
                topic.setId(rs.getInt("Id"));
                topic.setTitle(rs.getString("Title"));
                topics.add(topic);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnection.closeConnection(con);
        }

        return new TopicResults(topics, tagId, searchInput, pageNumber, numbOfRecords);
    }

    /* padarom atskira metoda kuris sukurs SQL dali kuri atsako uz WHERE salygas
    jai salyga yra pridedam jos teksta
    */
    private static String createWhereSQL(SearchBin searchBin) {
        String sql = "";

        String tagId = searchBin.getTagId();
        String searchInput = searchBin.getSearchInput();

        boolean isWhere = false;

        if (!tagId.equals("")) {
            sql = sql + " WHERE ";
            isWhere = true;

            sql = sql + "DocTagId = ?";
        }

        if (!searchInput.equals("")) {
            if (!isWhere) {
                sql = sql + " WHERE ";
                isWhere = true;
            } else {
                sql = sql + " AND ";
            }

            sql = sql + "Title LIKE '%'||?||'%'";
        }

        return sql;
    }

    /* cia idedam parametrus eiiskumo tvarka kaip dejom salygas
    ir grazinam sekancio parametro numeri
     */
    private static int fillParamsToSQL(SearchBin searchBin, PreparedStatement ps) throws SQLException{
        String tagId = searchBin.getTagId();
        String searchInput = searchBin.getSearchInput();

        int x = 1;

        //TagID yra integer bazeje todel reikia perduoti int o ne strong kad greitis butu
        if (!tagId.equals("")) {
            ps.setInt(x, Integer.parseInt(tagId));
            x++;
        }

        if (!searchInput.equals("")) {
            ps.setString(x, searchInput);
            x++;
        }

        return x;
    }

}
