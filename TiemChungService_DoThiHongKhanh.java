/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_DoThiHongKhanh;

import Dao_DoThiHongKhanh.TiemChungDao_DoThiHongKhanh;
import Model_DoThiHongKhanh.TiemChung_DoThiHongKhanh;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class TiemChungService_DoThiHongKhanh {
     private TiemChungDao_DoThiHongKhanh tcDao;

    public TiemChungService_DoThiHongKhanh() {
        tcDao = new TiemChungDao_DoThiHongKhanh();
    }

    public List<TiemChung_DoThiHongKhanh> getAllUsers() throws SQLException {
        return tcDao.getAllUsers();
    }

     public void addTC(TiemChung_DoThiHongKhanh tc) throws SQLException {
        tcDao.addTC(tc);
    }

}
