package dt06;

/* 创建类Users，包含3个方法
 * login(): 登录，将Users类中的在线用户数+1
 * logout()：退出，将Users类中的在线用户数-1
 * getUserNum()：返回在线用户数
 * 在main()中创建 Users对象，调用类中的方法 */
/* 创建类Login，继承Thread类
 * 在构造函数中，拿到main()中Users对象的引用
 * 重写run()函数，在run()中调用Users对象的login() 50次
 * 每次调用后，休眠100ms，然后输出Users对象中的在线用户数 */
/* 创建类Logout，实现Runnable接口
 * 在构造函数中，拿到main()中Users对象的引用
 * 重写run()函数，在run()中调用Users对象的logout() 50次
 * 每次调用后，休眠100ms */
/* 在main()中创建Login和Logout线程，并使之运行 */
public class TestThread {
  public static void main(String[] args) {
    Users users = new Users();
    Login login = new Login(users);
    Logout out = new Logout(users);
    Thread logout = new Thread(out);

    login.start();
    logout.start();
  }
}


class Users {
  private static int online = 0;

  public synchronized void login() {
    int newOnline = online + 1;
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    online = newOnline;
  }

  public synchronized void logout() {
    int newOnline = online - 1;
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    online = newOnline;
  }

  public int getUserNum() {
    return online;
  }
}


class Login extends Thread {
  private Users users;

  public Login(Users users) {
    this.users = users;
  }

  @Override
  public void run() {
    synchronized (users) {
      for (int i = 0; i < 50; i++) {
        users.login();
        System.out.print("+" + users.getUserNum() + " ");
      }
    }
  }
}


class Logout implements Runnable {
  private Users users;

  public Logout(Users users) {
    this.users = users;
  }

  @Override
  public void run() {
    synchronized (users) {
      for (int i = 0; i < 50; i++) {
        users.logout();
        System.out.print("-" + users.getUserNum() + " ");
      }
    }
  }
}
