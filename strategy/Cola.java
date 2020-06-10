public Class Cola{
    private BrandStrategy brandStrategy;
    public void product() {
      brandStrategy.brand();
    }
    
    public void setBrand(BrandStrategy brand) {
        this.brandStrategy = brand;
    }
}
