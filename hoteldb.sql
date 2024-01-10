-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2023 at 05:03 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNo` int(10) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `name`, `email`, `phoneNo`, `gender`) VALUES
('C0002', 'Fathima', 'fathima43@gmail.com', 758693524, 'Female'),
('C0003', 'Duminda', 'duminda56@gmail.com', 784596321, 'Male'),
('C0004', 'Nimna', 'nimna67@gmail.com', 775486996, 'Male'),
('C0005', 'Saweera', 'saweera@gmail.com', 701236554, 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `customerlogin`
--

CREATE TABLE `customerlogin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `currentPassword` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customerlogin`
--

INSERT INTO `customerlogin` (`username`, `password`, `currentPassword`) VALUES
('damitha', '0208', '0208'),
('deliya', '1126', '1126'),
('harshana', '0202', '0202'),
('sithumini', '0217', '0217');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('man', '321'),
('res', '123');

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `resNo` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNo` int(10) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `checkin` varchar(20) NOT NULL,
  `checkout` varchar(20) NOT NULL,
  `rtype` varchar(50) NOT NULL,
  `ptype` varchar(50) NOT NULL,
  `qty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`resNo`, `name`, `email`, `phoneNo`, `gender`, `checkin`, `checkout`, `rtype`, `ptype`, `qty`) VALUES
('R0001', 'Dinithi', 'dinithi12@gmail.com', 785469322, 'Female', '2023-10-27', '2023-10-29', 'A/C double room', 'None', 2),
('R0002', 'Fathima', 'fathima43@gmail.com', 758693524, 'Female', '2023-12-01', '2023-12-01', 'None', 'Wedding package', 100),
('R0003', 'Duminda', 'duminda56@gmail.com', 784596321, 'Male', '2023-11-05', '2023-11-08', 'A/C family room', 'None', 5),
('R0004', 'Saweera', 'saweera@gmail.com', 701236554, 'Female', '2023-12-01', '2023-12-02', 'None', 'Birthday party package', 50),
('R0005', 'Nimna', 'nimna67@gmail.com', 775486996, 'Male', '2023-11-21', '2023-11-25', 'A/C single room', 'None', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pId` varchar(5) NOT NULL,
  `rId` varchar(5) NOT NULL,
  `email` varchar(100) NOT NULL,
  `paytype` varchar(25) NOT NULL,
  `amount` float NOT NULL,
  `pstatus` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pId`, `rId`, `email`, `paytype`, `amount`, `pstatus`) VALUES
('P0001', 'R0001', 'dinithi12@gmail.com', 'Card', 120000, 'Non Paid'),
('P0002', 'R0002', 'fathima43@gmail.com', 'Card', 545000, 'Paid'),
('P0003', 'R0004', 'saweera@gmail.com', 'Cash', 10000, 'Paid'),
('P0004', 'R0005', 'nimna67@gmail.com', 'Cash', 24000, 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phoneNo` int(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `position` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `name`, `phoneNo`, `email`, `position`, `gender`) VALUES
('S0001', 'Damitha', 718331402, 'damitha@gmail.com', 'Manager', 'Male'),
('S0002', 'Sadupama', 714586456, 'Sandu@gmail.com', 'Receptionist', 'Female'),
('S0004', 'Harsh', 774829636, 'harsh@gmail.com', 'Manager', 'Male'),
('S0005', 'David', 748568969, 'david@gmail.com', 'Receptionist', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `customerlogin`
--
ALTER TABLE `customerlogin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`resNo`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
