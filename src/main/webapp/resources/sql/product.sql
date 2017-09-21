-- Base de données: `formation`

-- Structure de la table `product`
CREATE TABLE IF NOT EXISTS `product` (
  `ID` integer UNSIGNED NOT NULL auto_increment,
  `REFERENCE` VARCHAR(25) UNIQUE NOT NULL ,
  `DESIGNATION` VARCHAR(10) NOT NULL ,
  `PRICE` DECIMAL(6,2) NOT NULL ,
  `AMOUNT` VARCHAR(30) NOT NULL ,
  `CREATED` DATETIME,
  `UPDATED` DATETIME,
  PRIMARY KEY  (`ID`)
) AUTO_INCREMENT=10 ;

-- Contenu de la table `product`
INSERT INTO `product` (REFERENCE, DESIGNATION, PRICE, AMOUNT, CREATED, UPDATED) VALUES ('ABC', 'Livre Spring par la pratique', 25, 50, sysdate(), sysdate());
INSERT INTO `product` (REFERENCE, DESIGNATION, PRICE, AMOUNT, CREATED, UPDATED) VALUES ('ABD', 'Livre Comprendre Hibernate', 12, 100, sysdate(), sysdate());
INSERT INTO `product` (REFERENCE, DESIGNATION, PRICE, AMOUNT, CREATED, UPDATED) VALUES ('ABE', 'Livre Maitriser MySQL', 11, 200, sysdate(), sysdate());         