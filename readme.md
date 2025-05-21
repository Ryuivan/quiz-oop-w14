Sebuah restoran modern ingin membuat sistem berbasis teks yang digunakan untuk mengelola produk makanan dan minuman yang dijual. Produk-produk ini dapat berupa makanan (seperti nasi goreng, salad) maupun minuman (seperti kopi, teh). Setiap produk memiliki informasi umum seperti nama, harga, dan stok. Selain itu, makanan memiliki atribut tambahan apakah makanan tersebut vegetarian atau tidak, sedangkan minuman memiliki atribut ukuran (dalam ml). Sistem ini harus dapat melakukan pengelolaan data produk seperti menampilkan daftar produk, menambahkan produk baru, mengubah informasi produk yang sudah ada, menghapus produk, dan melakukan pembelian produk.

- Menampilkan Semua Produk
    
    Sistem menampilkan seluruh daftar produk (makanan dan minuman) yang tersedia, lengkap dengan informasi detail seperti nama, harga, stok, dan atribut khusus seperti vegetarian atau ukuran minuman.


- Menambahkan Produk Baru

    Pengguna dapat menambahkan produk baru baik makanan maupun minuman.
    Untuk makanan, pengguna diminta memilih apakah produk vegetarian atau tidak.
    Untuk minuman, pengguna mengisi ukuran dalam mililiter.


- Mengedit Produk

    Sistem memungkinkan pengguna untuk memilih produk berdasarkan ID lalu mengubah informasi nama, harga, dan stok.
    Jika produk berupa makanan, pengguna juga bisa mengubah status vegetarian.
    Untuk minuman, ukuran juga dapat diubah.


- Menghapus Produk

    Disediakan menu untuk menghapus produk berdasarkan ID.


- Membeli Produk

    Tersedia opsi pembelian produk dalam menu, beserta pengurangan stok dan input uang dari user.


- Pengelolaan ID Produk

    Setiap produk diberi ID unik berbentuk string yang bertambah otomatis saat seed dan saat penambahan produk baru.
    Produk makanan harus mempunyai kode “F” di bagian depan ID, sedangkan minuman kode depannya harus “D”.


- Validasi Input dan Penanganan Error

    Sistem melakukan pengecekan untuk menghindari crash saat input tidak valid.


https://docs.google.com/document/d/1zNBaDqtbZo58HTCx5VSR3upe7LYJ2B5EDOE1br352wI/edit?usp=sharing