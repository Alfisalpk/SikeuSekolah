-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2022 at 01:36 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `kode` varchar(100) NOT NULL,
  `nama_akun` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`kode`, `nama_akun`, `created_at`, `updated_at`, `deleted_at`) VALUES
('1111', 'Moli', '2022-10-05 12:33:05', '2022-10-05 12:33:05', NULL),
('123', 'Punjung', '2022-09-28 16:40:16', '2022-09-30 14:28:54', NULL),
('2001', 'Alfisal Punjung Kurniawan', '2022-09-30 14:29:19', '2022-10-01 14:26:10', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `angkatan`
--

CREATE TABLE `angkatan` (
  `tahun` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `angkatan`
--

INSERT INTO `angkatan` (`tahun`, `created_at`, `update_at`, `deleted_at`) VALUES
(2020, '2022-10-01 10:32:01', '2022-10-01 10:32:01', NULL),
(20001, '2022-10-05 12:33:17', '2022-10-05 12:33:17', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `biaya_lain`
--

CREATE TABLE `biaya_lain` (
  `id` bigint(20) NOT NULL,
  `akun_id` int(11) NOT NULL,
  `jurusan` bigint(20) NOT NULL,
  `nama_biaya` varchar(255) NOT NULL,
  `jumlah` double NOT NULL,
  `status` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `biaya_lain`
--

INSERT INTO `biaya_lain` (`id`, `akun_id`, `jurusan`, `nama_biaya`, `jumlah`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 2, 2, 'Biaya KU', 123, 234, '2022-10-05 22:06:27', '2022-10-05 22:06:27', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `biaya_pmb`
--

CREATE TABLE `biaya_pmb` (
  `id` bigint(20) NOT NULL,
  `akun_id` int(11) NOT NULL,
  `nama_biaya` varchar(255) NOT NULL,
  `jumlah` double NOT NULL,
  `tahun_angkatan` int(11) NOT NULL,
  `gelombang` varchar(255) NOT NULL,
  `jurusan` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `biaya_pmb`
--

INSERT INTO `biaya_pmb` (`id`, `akun_id`, `nama_biaya`, `jumlah`, `tahun_angkatan`, `gelombang`, `jurusan`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 2, 'PUNJUNG PUNYA', 12333, 20010, 'Covid', 12, '2022-10-05 21:34:00', '2022-10-05 21:34:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `biaya_tetap`
--

CREATE TABLE `biaya_tetap` (
  `id` bigint(20) NOT NULL,
  `akun_id` int(11) NOT NULL,
  `nama_biaya` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `jurusan` bigint(20) NOT NULL,
  `smt` bigint(20) NOT NULL,
  `tahun_angkatan` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jurusan`
--

CREATE TABLE `jurusan` (
  `id` bigint(20) NOT NULL,
  `nama_jurusan` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jurusan`
--

INSERT INTO `jurusan` (`id`, `nama_jurusan`, `created_at`, `update_at`, `deleted_at`) VALUES
(123, 'qwerty', '2022-10-01 14:25:12', '2022-10-01 14:25:12', NULL),
(2001, 'TKJ', '2022-10-01 14:18:23', '2022-10-01 14:18:23', NULL),
(2002, 'DKV', '2022-10-01 14:18:43', '2022-10-01 14:18:43', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id` varchar(100) NOT NULL,
  `kode_kelas` varchar(50) NOT NULL,
  `jurusan` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id`, `kode_kelas`, `jurusan`, `created_at`, `updated_at`, `deleted_at`) VALUES
('1', '98989', 2001, '2022-10-06 10:50:25', '2022-10-06 10:50:25', NULL),
('1111', 'KKKKK', 200, '2022-10-05 13:15:55', '2022-10-05 13:15:55', NULL),
('12', '23', 2002, '2022-10-06 11:00:29', '2022-10-06 11:05:01', NULL),
('123', 'asdadads', 7777, '2022-10-05 13:20:33', '2022-10-05 13:22:28', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id` varchar(15) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `angkatan` int(11) NOT NULL,
  `jurusan` bigint(20) NOT NULL,
  `kelas` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL,
  `du` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id`, `nis`, `nama`, `angkatan`, `jurusan`, `kelas`, `no_hp`, `du`, `password`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
('123', '1233333', 'qwewe', 324, 5435, 'ASD', '456', '546', '123', 'Aktif ya', '2022-10-05 15:50:36', '2022-10-05 15:50:36', NULL),
('999999', '88787878', 'qeedff', 2020, 2001, '23', '081325659017', 'tur', '23082001', 'Aktif', '2022-10-06 11:22:59', '2022-10-06 11:22:59', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('test', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `angkatan`
--
ALTER TABLE `angkatan`
  ADD PRIMARY KEY (`tahun`);

--
-- Indexes for table `biaya_lain`
--
ALTER TABLE `biaya_lain`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biaya_pmb`
--
ALTER TABLE `biaya_pmb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biaya_tetap`
--
ALTER TABLE `biaya_tetap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jurusan`
--
ALTER TABLE `jurusan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
