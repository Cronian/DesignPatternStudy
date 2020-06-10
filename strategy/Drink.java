public class Drink {
  public static void main(String args[]) {
    Cola cocaCola = new CocaCola();
    Cola pepsi = new Pepsi();
    
    cocaCola.setBrandStrategy(new CocaBrand());
    pepsi.setBrandStrategy(new PepsiBrand());
    
    cocaCola.product();
    pepsi.product();
  }
}
