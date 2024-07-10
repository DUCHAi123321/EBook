
package model;

import entity.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DAOOrderItem extends DBConnect {

    public int createOrderItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("orderItem cannot be null");
        }
        if (orderItem.getQuantity() < 0 || orderItem.getListPrice() < 0) {
            throw new IllegalArgumentException("this cannot be negative");
        }
        String insertOrderItemQuery = "INSERT INTO orderitem (orderid, itemid, bookid, listprice, quantity) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(insertOrderItemQuery);
            int nextItemId = getNextItemId(orderItem.getOrderId());
            pre.setInt(1, orderItem.getOrderId());
            pre.setInt(2, nextItemId);
            pre.setInt(3, orderItem.getBookId());
            pre.setDouble(4, orderItem.getListPrice());
            pre.setInt(5, orderItem.getQuantity());
            pre.executeUpdate();
            return 1;
        } catch (Exception ex) {
            System.err.print("SQLException");
            return 0;
        }
    }

    private int getNextItemId(int orderId) throws SQLException {
        String getMaxItemIdQuery = "SELECT MAX(itemid) FROM orderitem WHERE orderid = ?";
        PreparedStatement pre;
        pre = conn.prepareStatement(getMaxItemIdQuery);
        pre.setInt(1, orderId);
        ResultSet resultSet = pre.executeQuery();

        if (resultSet.next()) {
            int maxItemId = resultSet.getInt(1);
            return maxItemId + 1;
        } else {
            // No existing records in the order, start with item ID 1
            return 1;
        }
    }

}
