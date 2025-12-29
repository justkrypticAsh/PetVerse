<%@ page import="com.project.petverse.dao.PetDAO, com.project.petverse.model.Pet" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    PetDAO dao = new PetDAO();
    Pet pet = dao.getPetById(id);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Pet | PetVerse</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body>

<div class="container mt-4" style="max-width: 600px;">
    <h3>Edit Pet</h3>
    <hr>

    <form action="editPet" method="post">

        <input type="hidden" name="id" value="<%= pet.getId() %>" />

        <label>Name</label>
        <input type="text" name="name" value="<%= pet.getName() %>" class="form-control mb-2" required>

        <label>Age</label>
        <input type="number" name="age" value="<%= pet.getAge() %>" class="form-control mb-2" required>

        <label>Type</label>
        <input type="text" name="type" value="<%= pet.getType() %>" class="form-control mb-2" required>

        <label>Breed</label>
        <input type="text" name="breed" value="<%= pet.getBreed() %>" class="form-control mb-2">

        <label>Description</label>
        <textarea name="description" class="form-control mb-2" required><%= pet.getDescription() %></textarea>

        <label>Image URL</label>
        <input type="text" name="imageUrl" value="<%= pet.getImageUrl() %>" class="form-control mb-3" required>

        <button class="btn btn-warning w-100">Update Pet</button>

    </form>
</div>

</body>
</html>
