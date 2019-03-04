package models.DAO;

import controllers.DBconnection;
import models.DTO.SearchDTO;
import models.DTO.TopicDTO;
import models.beans.*;
import utils.ConfigurationProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicDAO {

    public static TopicDTO getTopicsFromDB(SearchDTO searchDTO) {
        List<TopicBean> topics = new ArrayList<>();
        String tagId = searchDTO.getTagId();
        String searchInput = searchDTO.getSearchInput();
        int pageNumber = searchDTO.getPageNumb();
        int numbOfTitles = ConfigurationProperties.SHOW_NUMB_OF_TITLES;
        int numbOfRecords = 0;

        searchDTO.setPsNextIndex(0); //del apsaugos sau, kad neturime dar indexo



        Connection con = DBconnection.getConnection();
        if (con != null) try {

            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String sqlWhere = createWhereSQL(searchDTO);
            int paramIndex;

            String sql = "SELECT count(*) FROM Topics";
            sql = sql + sqlWhere;

            PreparedStatement psCount;
            psCount = con.prepareStatement(sql);
            fillParamsToSQL(searchDTO, psCount);

            ResultSet rsCount = psCount.executeQuery();
            rsCount.next();
            numbOfRecords = rsCount.getInt(1);


            sql = "SELECT Id, Title FROM Topics";
            sql = sql + sqlWhere;
            sql = sql + " ORDER BY ViewCount DESC LIMIT ?, ?";

            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            fillParamsToSQL(searchDTO, ps);
            paramIndex = searchDTO.getPsNextIndex(); //cia pasiimam index. cia del 58 eilutes, kad teisingai nustatyti

                    //cia uzdedam limit parametrus
            ps.setInt(paramIndex, ((pageNumber - 1) * numbOfTitles));
            paramIndex++;
            ps.setInt(paramIndex, numbOfTitles);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TopicBean topic = new TopicBean();
                topic.setId(rs.getInt("Id"));
                topic.setTitle(rs.getString("Title"));
                topics.add(topic);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnection.closeConnection(con);
        }

        return new TopicDTO(topics, tagId, searchInput, pageNumber, numbOfRecords);
    }

    /* padarom atskira metoda kuris sukurs SQL dali kuri atsako uz WHERE salygas
    jai salyga yra pridedam jos teksta
    */
    private static String createWhereSQL(SearchDTO searchDTO) {
        String sql = "";

        String tagId = searchDTO.getTagId();
        String searchInput = searchDTO.getSearchInput();

        boolean isWhere = false; //kad dar nera salygos where, sql kodas tuscias

        if (!tagId.equals("")) {
            sql = sql + " WHERE ";
            isWhere = true; //jau panaudojom WHERE todel i 94-95 eilutes nesettinsim WHERE

            sql = sql + "DocTagId = ?";
        }

        //skaidome eilute i zodziu lista, ji uzsetinsime i searchDTO, nes sita lista naudosime ir kitoje funkcijoj, ty fillParams

        List<String> searchWords = new ArrayList<>(); //inicializavome
        String word;
        String[] Words = searchInput.split(" ");
        for(int i = 0; i < Words.length; i++) {
            word = Words[i]; //jei buvo daug tarpu ideta i search lauka, bus tuscios eilutes
            if (!word.equals("")) {
                searchWords.add(word);
            }
        }

        searchDTO.setSearchWords(searchWords);

        for(String w : searchWords) {

            if (!isWhere) {    //if Where sitoj vietioj. T. Y. Jei WHERE dar nepanaudotas, idek ji. Jei WHERE jau panaudotas, idek AND.
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
    private static void fillParamsToSQL(SearchDTO searchDTO, PreparedStatement ps) throws SQLException{
        String tagId = searchDTO.getTagId();

        List<String> searchWords = searchDTO.getSearchWords();
        //reikia perduoti Lista i ps
//        String searchInput = searchDTO.getSearchInput();

        int index = 1; //sito x mums dar reikes veliau kad padaryti TITLE limitus, kad rodytu tik po 10 elementu.

        //TagID yra integer bazeje todel reikia perduoti int o ne string kad greitis butu
        if (!tagId.equals("")) {
            ps.setInt(index, Integer.parseInt(tagId));
            index++;
        }

//        if (!searchInput.equals("")) {

        for (String word : searchWords) {
//            ps.setString(index, searchInput);
            ps.setString(index, word);
            index++;
        }

        searchDTO.setPsNextIndex(index); //cia settiname indexa, o pasiimsime ji kur 55 eilute
    }

}
