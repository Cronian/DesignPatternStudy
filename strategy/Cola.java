public Class Cola{
    private BrandStrategy brandStrategy;
    public void brand() {
      brandStrategy.brand();
    }
    
    public void setBrandStrategy(BrandStrategy brand) {
        this.brandStrategy = brand;
    }
}
