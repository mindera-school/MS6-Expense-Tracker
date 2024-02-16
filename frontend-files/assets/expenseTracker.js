let total = 0;
const expenses = [];

function addExpense() {
  const name = document.getElementById("name").value;
  const amount = parseFloat(document.getElementById("amount").value);
  if(amount>0){
    expenses.push({ name, amount });
  total += amount;
  document.getElementById("total").innerText = total.toFixed(2);
  renderExpenses();
  clearInput();
}
  if(amount<0.01)
  {
    alert("Please enter a positive amount");
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

function clearInput(){
  document.getElementById("name").value ="";
  document.getElementById("amount").value ="";
}