const baseUrl = "http://localhost:8080/api/products";
const categoriesUrl = "http://localhost:8080/api/categories";

// Load all products and categories on page load
document.addEventListener("DOMContentLoaded", () => {
    loadProducts();
    loadCategories();
});

// Load all products
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
                    <td>£${product.price.toFixed(2)}</td>
                    <td>${product.stock}</td>
                    <td>${product.description}</td>
                    <td>${product.category ? product.category.name : "No Category"}</td>
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

// Load all categories
function loadCategories() {
    fetch(categoriesUrl)
        .then(response => response.json())
        .then(categories => {
            const categorySelect = document.getElementById("category");
            categorySelect.innerHTML = "<option value=''>Select a category</option>";
            categories.forEach(category => {
                const option = document.createElement("option");
                option.value = category.id;
                option.textContent = category.name;
                categorySelect.appendChild(option);
            });
        })
        .catch(error => console.error("Error loading categories:", error));
}

// Submit form
document.getElementById("form").addEventListener("submit", function (event) {
    event.preventDefault();

    const id = document.getElementById("productId").value || null;
    const name = document.getElementById("name").value;
    const price = parseFloat(document.getElementById("price").value);
    const stock = parseInt(document.getElementById("stock").value);
    const description = document.getElementById("description").value;
    const categoryId = document.getElementById("category").value;

    const product = {
        name,
        price,
        stock,
        description,
        category: categoryId ? { id: categoryId } : null,
    };

    const method = id ? "PUT" : "POST";
    const url = id ? `${baseUrl}/${id}` : baseUrl;

    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product),
    })
        .then(() => {
            loadProducts();
            document.getElementById("form").reset();
        })
        .catch(error => console.error("Error saving product:", error));
});

// Edit a product
function editProduct(id) {
    fetch(`${baseUrl}/${id}`)
        .then(response => response.json())
        .then(product => {
            document.getElementById("productId").value = product.id;
            document.getElementById("name").value = product.name;
            document.getElementById("price").value = product.price;
            document.getElementById("stock").value = product.stock;
            document.getElementById("description").value = product.description;
            document.getElementById("category").value = product.category ? product.category.id : "";
        })
        .catch(error => console.error("Error loading product:", error));
}

// Delete a product
function deleteProduct(id) {
    fetch(`${baseUrl}/${id}`, { method: "DELETE" })
        .then(() => loadProducts())
        .catch(error => console.error("Error deleting product:", error));
}
