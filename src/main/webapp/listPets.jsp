<%@ page import="java.util.List" %>
<%@ page import="com.project.petverse.model.Pet" %>
<%@ include file="navbar.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>All Pets - PetVerse</title>
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
            background: linear-gradient(135deg, #f6d365, #fda085);
            font-family: 'Poppins', sans-serif;
        }

        .pet-card {
            border-radius: 20px;
            overflow: hidden;
            background: rgba(255,255,255,0.75);
            backdrop-filter: blur(8px);
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            transition: 0.3s;
        }

        .pet-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 30px rgba(0,0,0,0.35);
        }

        .pet-img {
            width: 100%;
            height: 220px;
            object-fit: cover;
        }

        h2 {
            font-weight: 700;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>

<body>

<h2>All Pets</h2>

<div class="container mt-4">
    <div class="row">

        <%
            List<Pet> pets = (List<Pet>) request.getAttribute("pets");
            if (pets != null && !pets.isEmpty()) {
                for (Pet p : pets) {
        %>

        <div class="col-md-4 mb-4">
            <div class="pet-card">
                <img src="<%= p.getImageUrl() %>" class="pet-img">

                <div class="p-3">
                    <h4><%= p.getName() %></h4>
                    <p><strong>Breed:</strong> <%= p.getBreed() %></p>
                    <p><strong>Age:</strong> <%= p.getAge() %> years</p>

                    <a href="#" class="btn btn-primary w-100">Adopt</a>
                </div>
            </div>
        </div>

        <%
                }
            } else {
        %>

        <p class="text-center mt-5">No pets added yet.</p>

        <% } %>

    </div>
</div>

</body>
</html>
