const baseUrl = "http://localhost:8080/api/products";

// Load all products on page load
document.addEventListener("DOMContentLoaded", loadProducts);

function loadProducts() {
    fetch(baseUrl)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#productTable tbody");
            tableBody.innerHTML = ""; // Clear existing rows
            data.forEach(product => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td>${product.description}</td>
                    <td>${product.category}</td>
                    <td>
                        <button onclick="editProduct(${product.id})">Edit</button>
                        <button onclick="deleteProduct(${product.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error("Error loading products:", error));
}

document.getElementById("form").addEventListener("submit", function (event) {
    event.preventDefault();
    const id = document.getElementById("productId").value;
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;
    const stock = document.getElementById("stock").value;
    const description = document.getElementById("description").value;
    const category = document.getElementById("category").value;

    const product = { name, price, stock, description, category };

    if (id) {
        // Update product
        fetch(`${baseUrl}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(product)
        })
            .then(() => loadProducts())
            .catch(error => console.error("Error updating product:", error));
    } else {
        // Create product
        fetch(baseUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(product)
        })
            .then(() => loadProducts())
            .catch(error => console.error("Error adding product:", error));
    }

    // Reset form
    document.getElementById("form").reset();
});

function editProduct(id) {
    fetch(`${baseUrl}/${id}`)
        .then(response => response.json())
        .then(product => {
            document.getElementById("productId").value = product.id;
            document.getElementById("name").value = product.name;
            document.getElementById("price").value = product.price;
            document.getElementById("stock").value = product.stock;
            document.getElementById("description").value = product.description;
            document.getElementById("category").value = product.category;
        })
        .catch(error => console.error("Error fetching product:", error));
}

function deleteProduct(id) {
    fetch(`${baseUrl}/${id}`, { method: "DELETE" })
        .then(() => loadProducts())
        .catch(error => console.error("Error deleting product:", error));
}
