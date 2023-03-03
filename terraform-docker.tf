terraform {
  required_providers {
    yandex = {
      source = "yandex-cloud/yandex"
    }
  }
  required_version = ">= 0.13"
}

provider "yandex" {
  token = "y0_AgAAAAAIdmfbAATuwQAAAADZWmJNdJFIYIbRRbyjmMd34a-1A741yWE"
  cloud_id = "b1gopdm17j2bn95lnlrc"
  folder_id = "b1gs7m6qh6b9juhfklmh"
  zone = "ru-central1-a"
}

variable "image-id" {
     type = string
}

resource "yandex_compute_instance" "vm-1" {
  name        = "from-terraform-vm"
  platform_id = "standard-v1"
  zone        = "ru-central1-a"

  resources {
    cores  = 2
    memory = 4
  }

  boot_disk {
    initialize_params {
      image_id = var.image-id
    }
  }

  network_interface {
    subnet_id = yandex_vpc_subnet.subnet-docker-1.id
    nat = true
  }

  metadata = {
    ssh-keys = "ubuntu:${file("~/.ssh/yandex_console_rsa.pub")}"
  }
}

resource "yandex_vpc_network" "network-docker-1" {
  name = "from-terraform-network-for-docker"
}

resource "yandex_vpc_subnet" "subnet-docker-1" {
  name           = "from-terraform-subnet-for-docker"
  zone           = "ru-central1-a"
  network_id     = "${yandex_vpc_network.network-docker-1.id}"
  v4_cidr_blocks = ["10.2.0.0/16"]
}

output "internal_ip_address_vm_1" {
  value = yandex_compute_instance.vm-1.network_interface.0.ip_address
}

output "external_ip_address_vm_1" {
  value = yandex_compute_instance.vm-1.network_interface.0.nat_ip_address
}
