const baseUrl = "http://localhost:8080/api/products";

// Load all products on page load
document.addEventListener("DOMContentLoaded", loadProducts);

function loadProducts() {
    fetch(baseUrl)
        .then(response => response.json())
        .then(data => updateTable(data))
        .catch(error => console.error("Error loading products:", error));
}

function formatPrice(price) {
    return new Intl.NumberFormat('en-GB', {
        style: 'currency',
        currency: 'GBP'
    }).format(price);
}

function updateTable(products) {
    const tableBody = document.querySelector("#productTable tbody");
    tableBody.innerHTML = ""; // Clear existing rows
    products.forEach(product => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${formatPrice(product.price)}</td>
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
}

document.getElementById("lowStockButton").addEventListener("click", () => {
    const threshold = document.getElementById("lowStockThreshold").value;
    fetch(`${baseUrl}/low-stock?threshold=${threshold}`)
        .then(response => response.json())
        .then(data => updateTable(data))
        .catch(error => console.error("Error fetching low-stock products:", error));
});
