<%@ include file="navbar.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Add Pet - PetVerse</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Fade-In Page */
body {
    animation: fadeIn 0.8s ease-in-out;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Smooth Hover Scale for Buttons */
.btn {
    transition: transform 0.2s ease, box-shadow 0.3s ease;
}

.btn:hover {
    transform: scale(1.05);
    box-shadow: 0 8px 20px rgba(0,0,0,0.3);
}

/* Floating Pet Cards Animation */
.pet-card {
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.pet-card:hover {
    transform: translateY(-10px) scale(1.02);
    box-shadow: 0 12px 30px rgba(0,0,0,0.4);
}

/* Glow Effect on Hover */
.pet-card:hover .pet-img {
    filter: brightness(1.15);
}

/* Form card smooth pop */
.form-card, .card-bg {
    animation: cardPop 0.6s ease;
}

@keyframes cardPop {
    from { opacity: 0; transform: scale(0.9); }
    to { opacity: 1; transform: scale(1); }
}

/* Navbar Slide Animation */
.navbar {
    animation: slideDown 0.6s ease;
}

@keyframes slideDown {
    from { opacity: 0; transform: translateY(-20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Button Wave Ripple */
.btn:active {
    transform: scale(0.92);
    transition: transform 0.1s;
}

/* Table Row Hover Animation */
.table-hover tbody tr:hover {
    background-color: rgba(0,0,0,0.05);
    transform: scale(1.01);
    transition: 0.2s;
}

        body {
            background: linear-gradient(135deg, #d4fc79, #96e6a1);
            min-height: 100vh;
            font-family: 'Poppins', sans-serif;
        }

        .form-card {
            background: rgba(255,255,255,0.40);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            width: 450px;
            margin: auto;
            margin-top: 40px;
        }

        .heading {
            text-align: center;
            font-weight: 700;
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

<div class="form-card">

    <h2 class="heading">Add New Pet 🐾</h2>

    <% if ("success".equals(request.getParameter("added"))) { %>
        <div class="alert alert-success">Pet added successfully!</div>
    <% } %>

    <% if ("error".equals(request.getParameter("err"))) { %>
        <div class="alert alert-danger">Something went wrong!</div>
    <% } %>

    <form action="addPet" method="post">

        <div class="mb-3">
            <label class="fw-bold">Pet Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="fw-bold">Breed</label>
            <input type="text" name="breed" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="fw-bold">Age</label>
            <input type="number" name="age" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="fw-bold">Image URL</label>
            <input type="text" name="imageUrl" class="form-control" required>
        </div>

        <button class="btn btn-success w-100">Add Pet</button>
    </form>
</div>

</body>
</html>
