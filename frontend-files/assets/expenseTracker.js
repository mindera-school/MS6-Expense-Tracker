let total = 0;
const expenses = [];

let nameExpense;
let amount;
function addExpense() {
  if (amount < 0.01) {
    alert("Please enter a valid amount");
  }
  if (nameExpense === "") {
    alert("Please enter a name to your expense");
  }

  nameExpense = document.getElementById("name").value;
  amount = parseFloat(document.getElementById("amount").value);

  if (amount > 0) {
    expenses.push({ nameExpense, amount });
    total += amount;
    document.getElementById("total").innerText = total.toFixed(2);
    renderExpenses();
    clearInput();
    sendJSON(nameExpense, amount);
  }
}

function removeExpense(index) {
  total -= expenses[index].amount;
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
                    ${expense.name}: ${expense.amount.toFixed(2)} €
                    <button id="remove" onclick="removeExpense(${index})"> x </button>
                `;
    expensesDiv.appendChild(expenseDiv);
  });
}

function clearInput() {
  document.getElementById("name").value = "";
  document.getElementById("amount").value = "";
}


async function sendJSON(nameExpense, amount) {
  const object = { nameExpense, amount };
  const jsonObject = JSON.stringify(object);
  console.log(jsonObject);

  const response = await fetch('http://localhost:8080/user', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: jsonObject 
  });

  const data = await response.text();
  console.log(data);
}