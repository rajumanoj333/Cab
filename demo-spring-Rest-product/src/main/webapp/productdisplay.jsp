<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo.Product" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>All Products</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Order Date</th>
        </tr>

        <!-- Iterate through the list of products directly using a simple for-each loop -->
        <%
            // Retrieve the 'list' attribute from the model
            List<Product> productList = (List<Product>) request.getAttribute("list");

            if (productList != null) {
                // Iterate over the product list and display each product
                for (Product product : productList) {
        %>
            <tr>
                <td><%= product.getPid() %></td>
                <td><%= product.getPname() %></td>
                <td><%= product.getPcost() %></td>
                <td><%= product.getPorderdt() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="4">No products available</td>
            </tr>
        <%
            }
        %>
    </table>
    <a href="/insert">Add New Product</a>
</body>
</html>
