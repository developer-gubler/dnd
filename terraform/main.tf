terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0.1"
    }
  }
}

provider "docker" {
  host = "npipe:////.//pipe//docker_engine"
}

resource "docker_network" "private_network" {
  name = "dnd_network"
}

# Pulls the postgres image
resource "docker_image" "postgres" {
  name = "postgres:latest"
}

# Create a postgres container
resource "docker_container" "postgres" {
  image = docker_image.postgres.image_id
  name  = "dnd_database"
  networks_advanced {
    name = docker_network.private_network.name
  }
  env      = ["POSTGRES_DB=dnd-database", "POSTGRES_USER=dnd-user", "POSTGRES_PASSWORD=dnd-secret"]
  must_run = "true"
}

# Pulls the pgadmin image
resource "docker_image" "pgadmin" {
  name = "dpage/pgadmin4:latest"
}

# Create a pgadmin container
resource "docker_container" "pgadmin" {
  image = docker_image.pgadmin.image_id
  name  = "dnd_pgadmin"
  ports {
    internal = 5050
    external = 5050
  }
  networks_advanced {
    name = docker_network.private_network.name
  }
  env      = ["PGADMIN_DEFAULT_EMAIL=developer.gubler@gmail.com", "PGADMIN_DEFAULT_PASSWORD=letmein", "PGADMIN_LISTEN_PORT=5050"]
  must_run = "true"
}
