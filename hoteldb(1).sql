-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 05 fév. 2024 à 22:49
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hoteldb`
--

-- --------------------------------------------------------

--
-- Structure de la table `boissons`
--

DROP TABLE IF EXISTS `boissons`;
CREATE TABLE IF NOT EXISTS `boissons` (
  `id_boisson` varchar(5) NOT NULL,
  `libelle_boisson` varchar(25) DEFAULT NULL,
  `quantite_boisson` int DEFAULT NULL,
  `prix_boisson` float DEFAULT NULL,
  PRIMARY KEY (`id_boisson`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `boissons`
--

INSERT INTO `boissons` (`id_boisson`, `libelle_boisson`, `quantite_boisson`, `prix_boisson`) VALUES
('BI1P', 'Pils', 1000, 600),
('BI1C', 'Chill', 1000, 500),
('BDJPL', 'Djama pils', 1000, 500),
('BDJLG', 'Djama lager', 1000, 600),
('BDJPA', 'Djama panaché', 1000, 500),
('BIRAC', 'Racine', 993, 500),
('BIAWY', 'Awooyo', 1000, 800),
('CHCOK', 'Chap cocktail', 996, 400);

-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

DROP TABLE IF EXISTS `chambres`;
CREATE TABLE IF NOT EXISTS `chambres` (
  `id_chambre` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_chambre` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `situation_chambre` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prix_chambre` float DEFAULT NULL,
  PRIMARY KEY (`id_chambre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `chambres`
--

INSERT INTO `chambres` (`id_chambre`, `type_chambre`, `situation_chambre`, `prix_chambre`) VALUES
(1, 'Single', 'Vue rue', 15000),
(2, 'Single', 'Vue jardin', 15500),
(3, 'Double', 'Vue jardin', 18000),
(4, 'Triple', 'Vue montagne', 25000),
(5, 'Triple', 'Vue mer', 23000),
(6, 'Single', 'Vue mer', 18200);

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id_client` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prenom_client` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel_client` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pays_client` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `categorie_client` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `carte_fidelite` enum('Oui','Non') COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id_client`, `nom_client`, `prenom_client`, `tel_client`, `pays_client`, `categorie_client`, `carte_fidelite`) VALUES
(1, 'Lucien', 'Luc', '79405594', 'Togo', 'VIP', 'Oui'),
(2, 'Moufid', 'Premier', '70564215', 'Nigeria', 'TOP', 'Oui'),
(3, 'Tamsir', 'Didier', '98754521', 'Côte d\'Ivoire', 'VIP', 'Non'),
(4, 'ZAGBA', 'Lerequin', '96564741', 'Côte d\'Ivoire', 'VIP', 'Oui'),
(5, 'SAWEGNON', 'Facbrice', '856230700', 'Côte d\'Ivoire', 'TOP', 'Non');

-- --------------------------------------------------------

--
-- Structure de la table `factures`
--

DROP TABLE IF EXISTS `factures`;
CREATE TABLE IF NOT EXISTS `factures` (
  `id_facture` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_reservation` int UNSIGNED DEFAULT NULL,
  `nom_client` varchar(40) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id_facture`),
  KEY `id_client` (`nom_client`),
  KEY `id_reservation` (`id_reservation`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `factures`
--

INSERT INTO `factures` (`id_facture`, `id_reservation`, `nom_client`, `total`) VALUES
(1, 2, 'Lucien', 18000),
(2, 4, 'Moufid', 36000);

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `id_plat` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `libelle_plat` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `quantite_plat` int DEFAULT NULL,
  `prix_plat` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `menu`
--

INSERT INTO `menu` (`id_plat`, `libelle_plat`, `quantite_plat`, `prix_plat`) VALUES
('PL001', 'Riz cantonais', -1, 1000),
('PL002', 'Foufou Sauce graine', 300, 600),
('PL003', 'Riz au gras', 500, 800),
('PL004', 'Foufou Sauce arrachide', -2, 600),
('PL005', 'Pâte sauce gombo', 100, 500),
('PL006', 'Spaghetti bolognaise', 150, 600);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `date_arrivee` date DEFAULT NULL,
  `date_depart` date DEFAULT NULL,
  `id_client` int UNSIGNED DEFAULT NULL,
  `id_chambre` int UNSIGNED DEFAULT NULL,
  `etat_reservation` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `id_client` (`id_client`),
  KEY `id_chambre` (`id_chambre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `date_arrivee`, `date_depart`, `id_client`, `id_chambre`, `etat_reservation`) VALUES
(1, '2023-12-16', '2023-12-19', 2, 1, 'Confirmée'),
(2, '2023-12-17', '2023-12-18', 1, 3, 'Confirmée'),
(3, '2024-01-11', '2024-01-14', 1, 2, 'Réservée'),
(4, '2024-01-29', '2024-01-31', 2, 3, 'Confirmée');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` tinyint UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userpassword` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id_user`, `username`, `userpassword`) VALUES
(1, 'lucien', '43210');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON DELETE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_chambre`) REFERENCES `chambres` (`id_chambre`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
