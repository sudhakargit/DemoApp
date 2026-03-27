terraform {
  required_version = ">= 1.0"
  
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }

  backend "s3" {
    bucket         = var.terraform_state_bucket  # From environment
    key            = "demoapp/terraform.tfstate"
    region         = var.aws_region               # From environment
    dynamodb_table = "terraform-locks"
    encrypt        = true
  }
}

provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      Environment = var.environment
      Project     = "DemoApp"
      ManagedBy   = "Terraform"
      GitHubRepo  = "sudhakargit/DemoApp"
    }
  }
}