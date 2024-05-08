package banking_system;

public class BankingSystem {
	public static void main(String[] args) {
		User[] users =new User[3];
		users[0]=new User("01","sham","sham@gmail");
		users[1]=new User("02","Ram","ram@gmail");
		users[2]=new User("03","ABC","abc@gmail");
		
		Transaction[] transactions = new Transaction[3];
		transactions[0]=new Transaction("011",2000.00,"deposite");
		transactions[1]=new Transaction("012",1000.00,"withdrawl");
		transactions[2]=new Transaction("013",500.0,"deposite");
		
		Manager manager = new Manager();
		simulateManager(manager,users,transactions);
	}

	private static void simulateManager(Manager manager, User[] users, Transaction[] transactions) {
		System.out.println("Manager is Working");
		Account account = new Account("123",5000);
		System.out.println("Balance : "+account.getbalance());
		manager.modifyAccountBalance(account, 1000.0);
		System.out.println("modifyAccountBalance :"+account.getbalance());
		System.out.println("Approving transaction");
		Transaction transaction = new Transaction("014",400.0,"withdrawl");
		Transaction transaction1 = new Transaction("015",500.0,"deposite");
		System.out.println("TransactionId: "+transaction.getTransactionId()+
				"Amount: "+transaction.getamount()+"Type :"+transaction.getType());
		System.out.println("TransactionId: "+transaction1.getTransactionId()+
				"Amount: "+transaction1.getamount()+"Type :"+transaction1.getType());
		manager.approveTransaction(transaction);

		Teller teller = new Teller();
        teller.deposit(account, 2000.00);// Example deposit by teller
        teller.withdrawl(account, 1000.0); // Example withdrawal by teller
        
        Administrator administrator = new Administrator();
        administrator.manageUsers(users); 
	}
}
	class Account {
		private String accountNumber;
		private double balance;

		public Account(String accountNumber, double balance) {
			this.accountNumber = accountNumber;
			this.balance = balance;
		}
		public double getbalance()
		{
			return balance;
		}
		public void setbalance(double balance)
		{
			this.balance=balance;
		}
	}

