-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 12, 2014 at 07:13 PM
-- Server version: 5.5.29
-- PHP Version: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `WishPalDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `Wish`
--

CREATE TABLE `Wish` (
  `WishCard` int(100) NOT NULL,
  `AgencyCode` varchar(50) DEFAULT NULL,
  `AgencyZone` varchar(100) DEFAULT NULL,
  `AgencyChildID` int(50) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `CardGender` varchar(50) DEFAULT NULL,
  `CardAge` varchar(50) DEFAULT NULL,
  `SpecialNeed` varchar(50) DEFAULT NULL,
  `Preamble` varchar(50) DEFAULT NULL,
  `GiftID` int(50) DEFAULT NULL,
  `GiftDescription` varchar(50) DEFAULT NULL,
  `GiftAttribute1` varchar(50) DEFAULT NULL,
  `ReceiptNotice` varchar(50) DEFAULT NULL,
  `Gift2Description` varchar(50) DEFAULT NULL,
  `Status` int(1) NOT NULL,
  PRIMARY KEY (`WishCard`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Wish`
--

INSERT INTO `Wish` (`WishCard`, `AgencyCode`, `AgencyZone`, `AgencyChildID`, `FirstName`, `CardGender`, `CardAge`, `SpecialNeed`, `Preamble`, `GiftID`, `GiftDescription`, `GiftAttribute1`, `ReceiptNotice`, `Gift2Description`, `Status`) VALUES
(40623, 'CUDDLE', '134', 29, 'Troy', 'Boy', '3 yrs', '', 'would like a', 3016, 'Thomas the Tank Train Play Tent', '', '', 'Little Mermaid Storybook Pillow', 1),
(40626, 'CUDDLE', '134', 4, 'Ilana', 'Girl', '3 yrs', '', 'would like a', 775, 'Play-Doh Crayola Big Bucket', '', '', 'Barbie Doll with her Convertible Car', 1),
(40628, 'CUDDLE', '134', 18, 'Xavier', 'Boy', '3 yrs', '', 'wants a', 1572, 'Lamborghini Toy Car', '', '', 'Fisher-Price Smilin Smart Phone', 0),
(40630, 'CUDDLE', '134', 17, 'Rosa', 'Girl', '4 yrs', '', 'wants a', 2253, 'Princess Beauty & the Beast', '', '', 'Princess Tea Set', 0),
(40634, 'CUDDLE', '134', 7, 'Wayne', 'Boy', '3 yrs', '', 'would like a', 4723, 'Silly Circus Tin Drum', '', '', 'Playground Ball', 0),
(40640, 'CUDDLE', '134', 9, 'Ariana', 'Girl', '3 yrs', '', 'would like a', 743, 'SpongeBob Fleece Blanket', '', '', 'LeapFrog Text & Learn', 0),
(40641, 'CUDDLE', '134', 27, 'Saiah ', 'Boy', '5 yrs', '', 'requested an', 5973, 'Iron Man Action Figure', '', '', 'Hasbro Iron Man Mask and Repulsor Gauntlet', 0),
(40643, 'CUDDLE', '134', 20, 'Najalee', 'Girl', '12 yrs', '', 'likes ', 263, 'Bath & Body Products', '', '', 'Movie Tickets for Century Theatres', 0),
(40646, 'CUDDLE', '134', 10, 'Ezmaria', 'Girl', '1 yr', '', 'wants a', 1589, 'Fisher-Price Dance & Play Puppy', '', '', 'Fisher-Price Laugh & Learn Learning Puppy', 0),
(40649, 'CUDDLE', '134', 23, 'Lynette', 'Girl', '3 yrs', '', 'wants some', 5466, 'Princess Dress Up Clothes & Wand', 'Sz: med  ', '(pls include a gift receipt for exchange)', 'Little Mommy Doll', 0),
(40651, 'ORANGE', '164', 78, 'Roy', 'Boy', '5 yrs', '', 'desires a', 2312, 'Remote Control Car with Batteries', '', '', 'Any Action Figure', 0),
(40652, 'ALPINE', '260', 33, 'JOHNNY', 'Boy', '4 yrs', '', 'just wants a', 2510, 'Skateboard', '', '', 'Dusty the Talking Vacuum Cleaner', 0),
(40659, 'ALPINE', '260', 47, 'MAX', 'Boy', '5 yrs', '', 'would like a', 5292, 'Fold Up Playhouse', '', '', 'Clock Radio with MP3 Player', 0),
(40660, 'ALPINE', '260', 63, 'TENSEN', 'Boy', '5 yrs', '', 'desires a', 2312, 'Remote Control Car with Batteries', '', '', 'Scooter (w/helmet if possible)', 1),
(40662, 'ALPINE', '260', 23, 'DAVID ALEXANDER', 'Boy', '5 yrs', '', 'wants a', 2393, 'Scooter (w/helmet if possible)', '', '', 'Remote Control Car with Batteries', 0),
(40665, 'ALPINE', '260', 37, 'KELLY', 'Girl', '3 yrs', '', 'likes ', 1397, 'Anything Hello Kitty', '', '', 'Baby Doll With Stroller', 1),
(40669, 'ALPINE', '260', 38, 'KENNETH', 'Boy', '4 yrs', '', 'would love a', 5553, 'Scooter', '', '', 'Matchbox Garage', 0),
(40670, 'ALPINE', '260', 30, 'GAVIN', 'Boy', '5 yrs', '', 'wants a', 2393, 'Scooter (w/helmet if possible)', '', '', 'Boom Box', 0),
(40672, 'ALPINE', '260', 13, 'BOBBY', 'Boy', '3 yrs', '', 'desires a', 1064, 'Pretend Tool Workshop', '', '', 'LEGO Set', 0),
(40678, 'ALIEN', '152', 4, 'AHMED', 'Boy', '4 yrs', '', 'would like a', 288, 'Batman Sleeping or Slumber Bag', '', '', 'Camping Sleeping Bag', 0),
(40679, 'ALIEN', '152', 48, 'MARA', 'Girl', '4 yrs', '', 'would like a', 3023, 'Three Wheel Scooter', '', '', 'Adjustable Inline Skates 1-4', 0),
(40680, 'ALIEN', '152', 62, 'SALVADOR', 'Boy', '4 yrs', '', 'wants a', 2322, 'Remote Controlled Truck W/batteries', '', '', 'First Act Digital Drum Pad', 0),
(40687, 'ALIEN', '152', 1, 'ABIGAIL', 'Girl', '4 yrs', '', 'would like a', 130, 'Baby Doll & Stroller', 'Ethnicity: Hispanic  ', '', 'Dora the Explorer Doll', 1),
(40689, 'ALIEN', '152', 57, 'PAULA', 'Girl', '3 yrs', '', 'would like a', 1234, 'Fisher-Price Laugh n Learn CD Player', '', '', 'LeapFrog Text & Learn', 0),
(40694, 'ALIEN', '152', 59, 'RICARDO', 'Boy', '3 yrs', '', 'would like a', 3019, 'Thomas The Train Set', '', '', 'LeapFrog Discovery Ball', 0),
(40697, 'ALIEN', '152', 72, 'ULISSES', 'Boy', '3 yrs', '', 'likes ', 1080, 'Elmo Toys', '', '', 'Sing with Elmo''s Greatest Hits', 0),
(40698, 'ALIEN', '152', 5, 'AKIRA', 'Boy', '3 yrs', '', 'would like a', 871, 'Disney Character Sleeping or SlumberBag', '', '', 'Boy''s Sleeping Bag', 0),
(40699, 'ALIEN', '152', 27, 'ERIN', 'Girl', '4 yrs', '', 'wants a', 4949, 'Baby Alive Hispanic Doll', '', '', 'Hispanic Baby Doll', 0),
(40700, 'ALIEN', '152', 33, 'ISAIAH', 'Boy', '4 yrs', '', 'hopes for a', 2708, 'Spy Lazer Tripwire W/Batteries', '', '', 'Play Camera', 1),
(40701, 'ALIEN', '152', 12, 'ANNA', 'Girl', '3 yrs', '', 'would like a', 1234, 'Fisher-Price Laugh n Learn CD Player', '', '', 'LeapFrog Learn and Groove Radio', 0),
(40703, 'ALIEN', '152', 35, 'JASMINE', 'Girl', '3 yrs', '', 'hopes for a', 935, 'Doll House', '', '', 'Princess & the Frog Doll', 0),
(40704, 'ALIEN', '152', 2, 'ADA', 'Girl', '3 yrs', '', 'wants a', 1146, 'Finger Painting Kit', '', '', 'Princess Sticker Kit', 0),
(40705, 'ALIEN', '152', 65, 'SHELIA', 'Girl', '3 yrs', '', 'wants a', 4110, 'Barbie Junior Laptop', '', '', 'Princess Walkie Talkies', 0),
(40708, 'ALIEN', '152', 29, 'EVIE', 'Girl', '3 yrs', '', 'hopes for a', 5702, 'You & Me 14" Hugs & Hold Doll - Caucasian', '', '', 'Baby Alive Caucasian Doll', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
