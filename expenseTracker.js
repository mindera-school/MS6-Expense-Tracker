let total = 0;
const expenses = [];

let name;
let amount;
function addExpense() {
  name = document.getElementById("name").value;
  amount = parseFloat(document.getElementById("amount").value);
  if(amount>0){
    expenses.push({ name, amount });
  total += amount;
  document.getElementById("total").innerText = total.toFixed(2);
  renderExpenses();
  clearInput();
  sendJSON(name, amount);
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
    test();
  });
}

function clearInput(){
  document.getElementById("name").value ="";
  document.getElementById("amount").value ="";
}

function sendJSON(name, amount){
const object={name, amount};
const jsonObject = JSON.stringify(object);
console.log(jsonObject);
}


function test(){
  const id = 1;
  const name = "pedro";
  const password = "123";
  const object={id,name, password};
  const jsonObject = JSON.stringify(object);
  console.log(jsonObject);
}