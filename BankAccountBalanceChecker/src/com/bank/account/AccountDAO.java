package com.bank.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {

    // Create new account
    public boolean createAccount(Account acc) {
        String sql = "INSERT INTO accounts(acc_no, holder_name, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, acc.getAccNo());
            pstmt.setString(2, acc.getHolderName());
            pstmt.setDouble(3, acc.getBalance());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch account by number
    public Account getAccountByNumber(int accNo) {
        String sql = "SELECT * FROM accounts WHERE acc_no = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accNo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Account(
                    rs.getInt("acc_no"),
                    rs.getString("holder_name"),
                    rs.getDouble("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}