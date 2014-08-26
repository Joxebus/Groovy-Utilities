def numerosTelefonicos = ["442-123-4567","442-123-4568","442-123-4569","442-1234560"]

numerosTelefonicos.each{ numero ->
    assert numero ==~ /(\d{3})-(\d{3})-(\d{4})/    
}
