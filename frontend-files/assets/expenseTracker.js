let total = 0;
const expenses = [];

let description;
let cost;
function addExpense() {
  description = document.getElementById("name").value;
  cost = parseFloat(document.getElementById("amount").value);

  if (cost < 0.01) {
    alert("Please enter a valid cost");
  }
  if (description === "") {
    alert("Please enter a name to your expense");
  }

  if (cost > 0) {
    expenses.push({ description, cost });
    total += cost;
    document.getElementById("total").innerText = total.toFixed(2);
    renderExpenses();
    clearInput();
    sendJSON(description, cost);
  }
}

function removeExpense(index) {
  total -= expenses[index].cost;
  expenses.splice(index, 1);
  document.getElementById("total").innerText = total.toFixed(2);
  renderExpenses();
}

function renderExpenses() {
  const expensesDiv = document.getElementById("expenses");
  expensesDiv.innerHTML = "";
  expenses.forEach((expense, index) => {
    const expenseDiv = document.createElement("div");
    expenseDiv.className = "expense";
    expenseDiv.innerHTML = `
                    ${expense.description}: ${expense.cost.toFixed(2)} €
                    <button id="remove" onclick="removeExpense(${index})"> x </button>
                `;
    expensesDiv.appendChild(expenseDiv);
  });
}

function clearInput() {
  document.getElementById("name").value = "";
  document.getElementById("amount").value = "";
}

async function sendJSON(description, cost) {
  const object = { description, cost };
  const jsonObject = JSON.stringify(object);
  console.log(jsonObject);
  const response = await fetch("http://localhost:8080/expense", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: jsonObject,
  });

  const data = await response.text();
  console.log(data);
}


