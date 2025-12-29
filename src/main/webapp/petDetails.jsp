<%@ page import="com.project.petverse.dao.PetDAO, com.project.petverse.model.Pet" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    PetDAO dao = new PetDAO();
    Pet pet = dao.getPetById(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Pet Details | PetVerse</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body>

<div class="container mt-4">

    <h2><%= pet.getName() %></h2>
    <img src="<%= pet.getImageUrl() %>" class="img-fluid mb-3" style="max-height: 350px;">

    <p><strong>Type:</strong> <%= pet.getType() %></p>
    <p><strong>Breed:</strong> <%= pet.getBreed() %></p>
    <p><strong>Age:</strong> <%= pet.getAge() %></p>
    <p><strong>Description:</strong> <%= pet.getDescription() %></p>

    <% if (!pet.isAdopted()) { %>
        <a href="adoptPet?id=<%= pet.getId() %>" class="btn btn-success">Adopt</a>
    <% } else { %>
        <span class="badge bg-secondary">Already Adopted</span>
    <% } %>

    <a href="home.jsp" class="btn btn-outline-primary ms-2">Back</a>
</div>

</body>
</html>
