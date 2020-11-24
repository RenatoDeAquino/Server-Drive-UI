//nesse exmplo eu estou usando o banco de dados postgres

const Pool = require('pg').Pool
const pool = new Pool({
    user: 'seu usario do postgres',
    host: 'o host do ser servidor do banco de dados',
    database: 'a data base da qual vai ser pego suas informações',
    password: 'a senha pra coneção com o banco de dados',
    port://porta do qual vai ser executado a api que faz conexão ao banco de dados no meu caso eu usei a porta 5432,

});


const getInfos = () => {
    return new Promise(function(resolve, reject) {
      pool.query('SELECT * FROM info_users ORDER BY id ASC', (error, results) => {
        if (error) {
          reject(error)
        }
        resolve(results.rows);
      })
    }) 
  }
  const createInfos = (body) => {
    return new Promise(function(resolve, reject) {
      const { nome, saldo, extrato } = body
      pool.query('INSERT INTO info_users (name, saldo, extrato) VALUES ($1, $2, $3) RETURNING *', [nome, saldo, extrato], (error, results) => {
        if (error) {
          reject(error)
        }
        resolve(`A new infos has been added : ${results.rows[0]}`)
      })
    })
  }
  const deleteInfos = () => {
    return new Promise(function(resolve, reject) {
      const id = parseInt(request.params.id)
      pool.query('DELETE FROM info_users WHERE id = $1', [id], (error, results) => {
        if (error) {
          reject(error)
        }
        resolve(`Merchant deleted with ID: ${id}`)
      })
    })
  }
  
  module.exports = {
    getInfos,
    createInfos,
    deleteInfos,
  }
