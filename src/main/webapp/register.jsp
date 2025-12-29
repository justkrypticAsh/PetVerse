<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Register - PetVerse</title>
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
            background: linear-gradient(135deg, #a1c4fd, #c2e9fb);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Poppins', sans-serif;
        }
        .card-bg {
            background: rgba(255,255,255,0.30);
            backdrop-filter: blur(12px);
            border-radius: 20px;
            padding: 35px;
            width: 420px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        }
        .heading {
            font-weight: 700;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="card-bg">
    <h2 class="heading mb-4">Create Account 🐾</h2>

    <% if ("1".equals(request.getParameter("exists"))) { %>
        <div class="alert alert-warning">
            Email already exists! Try login instead.
        </div>
    <% } %>

    <% if ("error".equals(request.getParameter("err"))) { %>
        <div class="alert alert-danger">
            Something went wrong. Try again!
        </div>
    <% } %>

    <form action="register" method="post">

        <div class="mb-3">
            <label class="fw-bold">Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="fw-bold">Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="fw-bold">Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-success w-100">
            Create Account
        </button>

        <p class="text-center mt-3">
            Already have an account?
            <a href="login.jsp">Login</a>
        </p>

    </form>
</div>

</body>
</html>
