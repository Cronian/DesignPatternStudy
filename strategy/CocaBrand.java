public class CocaBrand implements BrandStrategy {
    private String brand;
    public Coca() {
      this.brand = "Coca Cola";
    }
    
    public void brand() {
      System.out.println(this.brand); 
    }
}
