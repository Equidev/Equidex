-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 12 Avril 2017 à 08:20
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `equidex`
--

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE `activite` (
  `idActivite` int(11) NOT NULL,
  `nomActivite` varchar(25) DEFAULT NULL,
  `tarifHeure` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `activite`
--

INSERT INTO `activite` (`idActivite`, `nomActivite`, `tarifHeure`) VALUES
(13, 'Jeremy fait du dada', 200),
(15, 'Jeremy est une goudou', 50),
(19, 'Jeremy a toute vitesse', 75),
(26, 'Jeremy sent le fromage', 10),
(28, 'Balade', 20),
(30, 'da', 5),
(34, 'encore plus', 240),
(36, 'daad', 56),
(37, 'dafa', 20);

-- --------------------------------------------------------

--
-- Structure de la table `affecter`
--

CREATE TABLE `affecter` (
  `numParticipation` int(11) NOT NULL,
  `idCheval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `assigner`
--

CREATE TABLE `assigner` (
  `idClient` int(11) NOT NULL,
  `idTypeForfait` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cheval`
--

CREATE TABLE `cheval` (
  `idCheval` int(11) NOT NULL,
  `nomCheval` varchar(64) NOT NULL,
  `dateNaissCheval` date NOT NULL,
  `matriculeCheval` varchar(25) NOT NULL,
  `sexeCheval` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nomClient` varchar(64) DEFAULT NULL,
  `prenomClient` varchar(64) DEFAULT NULL,
  `mailClient` varchar(255) DEFAULT NULL,
  `telClient` varchar(11) DEFAULT NULL,
  `CPClient` varchar(6) DEFAULT NULL,
  `rueClient` varchar(255) DEFAULT NULL,
  `villeClient` varchar(127) DEFAULT NULL,
  `dateNaissClient` date DEFAULT NULL,
  `idNiveau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `prenomClient`, `mailClient`, `telClient`, `CPClient`, `rueClient`, `villeClient`, `dateNaissClient`, `idNiveau`) VALUES
(1, 'Cluzeaux', 'Jeremy', 'jeremc@gmail.com', '0601010101', '79000', 'rue tedumatin', 'Aiffre', '1997-03-20', 5);

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE `equipement` (
  `idFrais` int(11) NOT NULL,
  `idEquipement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `frais`
--

CREATE TABLE `frais` (
  `idFrais` int(11) NOT NULL,
  `coutFrais` double DEFAULT NULL,
  `dateFrais` date DEFAULT NULL,
  `quantiteFrais` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medical`
--

CREATE TABLE `medical` (
  `commMedical` varchar(25) DEFAULT NULL,
  `idFrais` int(11) NOT NULL,
  `idSoin` int(11) DEFAULT NULL,
  `idCheval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `natureacti`
--

CREATE TABLE `natureacti` (
  `idNature` int(11) NOT NULL,
  `LibelleNature` varchar(127) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `idNiveau` int(11) NOT NULL,
  `libelleNiveau` varchar(31) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`idNiveau`, `libelleNiveau`) VALUES
(1, 'Galop 0'),
(2, 'Galop 1'),
(3, 'Galop 2'),
(4, 'Galop 3'),
(5, 'Galop 4'),
(6, 'Galop 5'),
(7, 'Galop 6'),
(8, 'Galop 7');

-- --------------------------------------------------------

--
-- Structure de la table `nourriture`
--

CREATE TABLE `nourriture` (
  `idFrais` int(11) NOT NULL,
  `idNourriture` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

CREATE TABLE `participer` (
  `numParticipation` int(11) NOT NULL,
  `idClient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `poney`
--

CREATE TABLE `poney` (
  `idCheval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `referer`
--

CREATE TABLE `referer` (
  `idActivite` int(11) NOT NULL,
  `idNiveau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `referer`
--

INSERT INTO `referer` (`idActivite`, `idNiveau`) VALUES
(15, 1),
(19, 1),
(26, 1),
(30, 1),
(34, 1),
(15, 2),
(19, 2),
(26, 2),
(28, 2),
(34, 2),
(36, 2),
(28, 3),
(30, 3),
(34, 3),
(37, 3),
(28, 4),
(34, 4),
(37, 4),
(34, 5),
(36, 5),
(34, 6),
(36, 6),
(13, 7),
(34, 7),
(13, 8),
(34, 8);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE `seance` (
  `numParticipation` int(11) NOT NULL,
  `dateHeure` datetime DEFAULT NULL,
  `idActivite` int(11) DEFAULT NULL,
  `idNature` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typeequipement`
--

CREATE TABLE `typeequipement` (
  `idEquipement` int(11) NOT NULL,
  `libelleEquipement` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typeforfait`
--

CREATE TABLE `typeforfait` (
  `idTypeForfait` int(11) NOT NULL,
  `libelleTypeForfait` varchar(127) NOT NULL,
  `montantTypeForfait` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typenourriture`
--

CREATE TABLE `typenourriture` (
  `idNourriture` int(11) NOT NULL,
  `libelleNourriture` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typesoin`
--

CREATE TABLE `typesoin` (
  `idSoin` int(11) NOT NULL,
  `libelleSoin` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `activite`
--
ALTER TABLE `activite`
  ADD PRIMARY KEY (`idActivite`);

--
-- Index pour la table `affecter`
--
ALTER TABLE `affecter`
  ADD PRIMARY KEY (`numParticipation`,`idCheval`),
  ADD KEY `FK_affecter_idCheval` (`idCheval`);

--
-- Index pour la table `assigner`
--
ALTER TABLE `assigner`
  ADD PRIMARY KEY (`idClient`,`idTypeForfait`),
  ADD KEY `FK_assigner_idTypeForfait` (`idTypeForfait`);

--
-- Index pour la table `cheval`
--
ALTER TABLE `cheval`
  ADD PRIMARY KEY (`idCheval`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `FK_Client_idNiveau` (`idNiveau`);

--
-- Index pour la table `equipement`
--
ALTER TABLE `equipement`
  ADD PRIMARY KEY (`idFrais`),
  ADD KEY `FK_Equipement_idEquipement` (`idEquipement`);

--
-- Index pour la table `frais`
--
ALTER TABLE `frais`
  ADD PRIMARY KEY (`idFrais`);

--
-- Index pour la table `medical`
--
ALTER TABLE `medical`
  ADD PRIMARY KEY (`idFrais`),
  ADD KEY `FK_Medical_idSoin` (`idSoin`),
  ADD KEY `FK_Medical_idCheval` (`idCheval`);

--
-- Index pour la table `natureacti`
--
ALTER TABLE `natureacti`
  ADD PRIMARY KEY (`idNature`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`idNiveau`);

--
-- Index pour la table `nourriture`
--
ALTER TABLE `nourriture`
  ADD PRIMARY KEY (`idFrais`),
  ADD KEY `FK_Nourriture_idNourriture` (`idNourriture`);

--
-- Index pour la table `participer`
--
ALTER TABLE `participer`
  ADD PRIMARY KEY (`numParticipation`,`idClient`),
  ADD KEY `FK_participer_idClient` (`idClient`);

--
-- Index pour la table `poney`
--
ALTER TABLE `poney`
  ADD PRIMARY KEY (`idCheval`);

--
-- Index pour la table `referer`
--
ALTER TABLE `referer`
  ADD PRIMARY KEY (`idActivite`,`idNiveau`),
  ADD KEY `FK_referer_idNiveau` (`idNiveau`);

--
-- Index pour la table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`numParticipation`),
  ADD KEY `FK_Seance_idActivite` (`idActivite`),
  ADD KEY `FK_Seance_idNature` (`idNature`);

--
-- Index pour la table `typeequipement`
--
ALTER TABLE `typeequipement`
  ADD PRIMARY KEY (`idEquipement`);

--
-- Index pour la table `typeforfait`
--
ALTER TABLE `typeforfait`
  ADD PRIMARY KEY (`idTypeForfait`);

--
-- Index pour la table `typenourriture`
--
ALTER TABLE `typenourriture`
  ADD PRIMARY KEY (`idNourriture`);

--
-- Index pour la table `typesoin`
--
ALTER TABLE `typesoin`
  ADD PRIMARY KEY (`idSoin`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `activite`
--
ALTER TABLE `activite`
  MODIFY `idActivite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT pour la table `cheval`
--
ALTER TABLE `cheval`
  MODIFY `idCheval` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `frais`
--
ALTER TABLE `frais`
  MODIFY `idFrais` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `natureacti`
--
ALTER TABLE `natureacti`
  MODIFY `idNature` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `idNiveau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `seance`
--
ALTER TABLE `seance`
  MODIFY `numParticipation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeequipement`
--
ALTER TABLE `typeequipement`
  MODIFY `idEquipement` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeforfait`
--
ALTER TABLE `typeforfait`
  MODIFY `idTypeForfait` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typenourriture`
--
ALTER TABLE `typenourriture`
  MODIFY `idNourriture` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typesoin`
--
ALTER TABLE `typesoin`
  MODIFY `idSoin` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `affecter`
--
ALTER TABLE `affecter`
  ADD CONSTRAINT `FK_affecter_idCheval` FOREIGN KEY (`idCheval`) REFERENCES `cheval` (`idCheval`),
  ADD CONSTRAINT `FK_affecter_numParticipation` FOREIGN KEY (`numParticipation`) REFERENCES `seance` (`numParticipation`);

--
-- Contraintes pour la table `assigner`
--
ALTER TABLE `assigner`
  ADD CONSTRAINT `FK_assigner_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `FK_assigner_idTypeForfait` FOREIGN KEY (`idTypeForfait`) REFERENCES `typeforfait` (`idTypeForfait`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_Client_idNiveau` FOREIGN KEY (`idNiveau`) REFERENCES `niveau` (`idNiveau`);

--
-- Contraintes pour la table `equipement`
--
ALTER TABLE `equipement`
  ADD CONSTRAINT `FK_Equipement_idEquipement` FOREIGN KEY (`idEquipement`) REFERENCES `typeequipement` (`idEquipement`),
  ADD CONSTRAINT `FK_Equipement_idFrais` FOREIGN KEY (`idFrais`) REFERENCES `frais` (`idFrais`);

--
-- Contraintes pour la table `medical`
--
ALTER TABLE `medical`
  ADD CONSTRAINT `FK_Medical_idCheval` FOREIGN KEY (`idCheval`) REFERENCES `cheval` (`idCheval`),
  ADD CONSTRAINT `FK_Medical_idFrais` FOREIGN KEY (`idFrais`) REFERENCES `frais` (`idFrais`),
  ADD CONSTRAINT `FK_Medical_idSoin` FOREIGN KEY (`idSoin`) REFERENCES `typesoin` (`idSoin`);

--
-- Contraintes pour la table `nourriture`
--
ALTER TABLE `nourriture`
  ADD CONSTRAINT `FK_Nourriture_idFrais` FOREIGN KEY (`idFrais`) REFERENCES `frais` (`idFrais`),
  ADD CONSTRAINT `FK_Nourriture_idNourriture` FOREIGN KEY (`idNourriture`) REFERENCES `typenourriture` (`idNourriture`);

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `FK_participer_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `FK_participer_numParticipation` FOREIGN KEY (`numParticipation`) REFERENCES `seance` (`numParticipation`);

--
-- Contraintes pour la table `poney`
--
ALTER TABLE `poney`
  ADD CONSTRAINT `FK_Poney_idCheval` FOREIGN KEY (`idCheval`) REFERENCES `cheval` (`idCheval`);

--
-- Contraintes pour la table `referer`
--
ALTER TABLE `referer`
  ADD CONSTRAINT `FK_referer_idActivite` FOREIGN KEY (`idActivite`) REFERENCES `activite` (`idActivite`),
  ADD CONSTRAINT `FK_referer_idNiveau` FOREIGN KEY (`idNiveau`) REFERENCES `niveau` (`idNiveau`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `FK_Seance_idActivite` FOREIGN KEY (`idActivite`) REFERENCES `activite` (`idActivite`),
  ADD CONSTRAINT `FK_Seance_idNature` FOREIGN KEY (`idNature`) REFERENCES `natureacti` (`idNature`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
