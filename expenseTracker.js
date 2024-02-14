let total = 0;
const expenses = [];

function addExpense() {
  const name = document.getElementById("name").value;
  const amount = parseFloat(document.getElementById("amount").value);
  expenses.push({ name, amount });
  total += amount;
  document.getElementById("total").innerText = total.toFixed(2);
  renderExpenses();
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
                    <button onclick="removeExpense(${index})"> Remove</button>
                `;
    expensesDiv.appendChild(expenseDiv);
  });
}
