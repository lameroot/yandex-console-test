source "yandex" "ubuntu-docker" {
   token               = "y0_AgAAAAAIdmfbAATuwQAAAADZWmJNdJFIYIbRRbyjmMd34a-1A741yWE"
   folder_id           = "b1gs7m6qh6b9juhfklmh"
   source_image_family = "ubuntu-2004-lts"
   ssh_username        = "ubuntu"
   use_ipv4_nat        = "true"
   image_description   = "my custom ubuntu with docker"
   image_family        = "ubuntu-2004-lts"
   image_name          = "my-ubuntu-docker"
   subnet_id           = "e9b4v75k612o99007c8o"
   disk_type           = "network-ssd"
   zone                = "ru-central1-a"
 }

 build {
   sources = ["source.yandex.ubuntu-docker"]

   provisioner "shell" {
     inline = ["sudo apt-get update -y",
           "sudo apt-get install git -y",
           "sudo apt-get install docker.io -y", 
	   "sudo apt-get install docker-compose -y", 
	   "sudo apt-get install maven -y"]
   }
 }
