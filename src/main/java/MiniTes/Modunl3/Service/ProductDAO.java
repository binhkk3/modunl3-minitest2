package MiniTes.Modunl3.Service;

import MiniTes.Modunl3.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IUProductDAO {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo20062?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,name,price,quantity) value  (?,?,?,?)");) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> sortPrice() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement("Select * from product order by price");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price,quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from product");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price,quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findAllOderByAge() {
        return null;
    }

    @Override
    public List<Product> findAllByName(String key) {
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from product where name like ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,"%"+ key +"%");
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(id, name, price,quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,name,price,quantity) value  (?,?,?,?)");) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }


}
